package com.bugvm.gradle

/**
 *
 * @author joeri
 */
abstract class BasicTest {

    protected void deleteDir(File root) {
        if (root.exists()) {
            for (File file : root.listFiles()) {
                if (file.isDirectory()) {
                    deleteDir(file)
                } else {
                    file.delete()
                }
            }
            root.delete()
        }
    }

}
