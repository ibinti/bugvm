project(bc)

include_directories(../../core/include ${CMAKE_BINARY_DIR}/gc/include)

if (WITH_FPIC)
  remove_definitions(-fPIC)
endif()

add_library(bugvm-bc STATIC
  bc.c
  classinfo.c
  MurmurHash3.c
)

set_target_properties(bugvm-bc PROPERTIES SUFFIX "${LIB_SUFFIX}")
install(TARGETS bugvm-bc DESTINATION ${INSTALL_DIR})
