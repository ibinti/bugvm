project(rt)

add_subdirectory(bugvm)
add_subdirectory(android)

add_library(bugvm-rt STATIC ${BUGVM_RT_CORE_OBJECTS} ${ANDROID_OBJECTS})
set_target_properties(bugvm-rt PROPERTIES SUFFIX "${LIB_SUFFIX}")
merge_static_lib_object_files(bugvm-rt 'Java_*' 'bugvmRT*')
install(TARGETS bugvm-rt DESTINATION ${INSTALL_DIR})
