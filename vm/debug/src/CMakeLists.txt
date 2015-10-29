project(debug)

include_directories(../../core/include ${CMAKE_BINARY_DIR}/gc/include)

set(SRC
  debug.c 
)

add_library(bugvm-debug STATIC ${SRC})

set_target_properties(bugvm-debug PROPERTIES SUFFIX "${LIB_SUFFIX}")
install(TARGETS bugvm-debug DESTINATION ${INSTALL_DIR})
