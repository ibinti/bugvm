class javacpp {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Running javacpp!")
            for( a in args) {
                println(a)
            }
            org.bytedeco.javacpp.tools.Builder.main(args)
        }
    }

}