#!/bin/bash

export HOME=$(cd ~; pwd)

BASE=$(cd $(dirname $0)/../..; pwd -P)
if [ -f "$BASE/tests/drlvm/bugvm-vts.env" ]; then
  . $BASE/tests/drlvm/bugvm-vts.env
fi
[ "x$ARCH" == 'x' ] && ARCH=x86_64
if [ "x$OS" == 'x' ]; then
  if [ $(uname) == 'Darwin' ]; then
    OS=macosx
  else
    OS=linux
  fi
fi
EXTRA_ARGS=
if [ "x$DEBUG" == 'x1' ]; then
  EXTRA_ARGS="$EXTRA_ARGS -debug"
  [ "x$TARGET" == 'x' ] && TARGET=/tmp/bugvm-vts.$OS-$ARCH.debug
else
  [ "x$TARGET" == 'x' ] && TARGET=/tmp/bugvm-vts.$OS-$ARCH.release
fi
[ "x$USE_DEBUG_LIBS" == 'x1' ] && EXTRA_ARGS="$EXTRA_ARGS -use-debug-libs"
[ "x$ARGS" != 'x' ] && EXTRA_ARGS="$EXTRA_ARGS $ARGS"

if [ "$OS" == 'ios' ]; then
  EXTRA_ARGS="$EXTRA_ARGS -libs $BASE/tests/drlvm/drlvm-vts-bundle/vts/dest/VTS-built/bin/lib/libjnitests.a"
else
  EXTRA_ARGS="$EXTRA_ARGS -dynamic-jni"
fi

export PATH

mkdir -p $HOME/.bugvm/vts/

n=0
while [ ${1:0:1} = '-' ]; do
  if [ "$1" = '-cp' ]; then
    shift
    parts=$(echo $1 | tr ':' '\n')
    for p in $parts; do
      if [ -d "$p" ]; then
        JAR=$HOME/.bugvm/vts/vts$n.jar
        if [ ! -f "$JAR" ]; then
          jar cf $JAR -C "$p" .
        fi
        CP=$(test "x$CP" = "x" && echo "$JAR" || echo "$CP:$JAR")
        n=$((n + 1))
      elif [ -f "$p" ]; then
        CP=$(test "x$CP" = "x" && echo "$p" || echo "$CP:$p")
      fi
    done
  fi
  shift
done

MAINCLASS=$1
shift

while [ "x$1" != 'x' ]; do
  RUNARGS="$RUNARGS $1"
  shift
done

#echo "RUNARGS=$RUNARGS"
#echo "MAINCLASS=$MAINCLASS"

mkdir -p "$TARGET"
if [ ! -x $TARGET/vts ]; then
  if [ "x$BUGVM_HOME" != 'x' ]; then
    BUGVM="$BUGVM_HOME/bin/bugvm"
  else
    export BUGVM_DEV_ROOT=$BASE
    BUGVM="$BUGVM_DEV_ROOT/bin/bugvm"
  fi
  if [ "$OS" == 'ios' ]; then
    if [ "x$KEYCHAIN_PASSWORD" != "x" ]; then
      security unlock-keychain -p $KEYCHAIN_PASSWORD
    fi
  fi
  "$BUGVM" \
    -tmp $TARGET.tmp \
    -d $TARGET \
    -arch $ARCH \
    -os $OS \
    -o vts \
    -verbose \
    $EXTRA_ARGS \
    -cp $CP &> $TARGET/bugvm.log
  RET=$?
  if [ "$RET" != "0" ]; then
    exit $RET
  fi
  if [ "x$SSH_HOST" != 'x' ]; then
    rsync -a --delete -e "ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -o LogLevel=quiet" $TARGET/ $SSH_HOST:$TARGET/ >> $TARGET/bugvm.log
  fi
fi

LIBPATH=$TARGET
if [ "x$LD_LIBRARY_PATH" != 'x' ]; then
  LIBPATH=$LIBPATH:$LD_LIBRARY_PATH
fi
if [ "x$DYLD_LIBRARY_PATH" != 'x' ]; then
  LIBPATH=$LIBPATH:$DYLD_LIBRARY_PATH
fi

if [ "x$SSH_HOST" != 'x' ]; then
  ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -o LogLevel=quiet $SSH_HOST $TARGET/vts -rvm:MainClass=$MAINCLASS $RUNARGS
else
  LD_LIBRARY_PATH=$LIBPATH DYLD_LIBRARY_PATH=$LIBPATH $TARGET/vts -rvm:MainClass=$MAINCLASS $RUNARGS
fi
CODE=$?
exit $CODE
