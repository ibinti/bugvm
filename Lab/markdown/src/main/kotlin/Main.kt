object Main {

    @JvmStatic fun main(args: Array<String>) {

        md()

    }

    fun md() {
        val textInMarkdown = """

# Heading

## Sub-heading

### Another deeper heading

Paragraphs are separated
by a blank line.

Text attributes _italic_, *italic*, __bold__, **bold**, `monospace`.

Horizontal rule:

---

Bullet list:

  * apples
  * oranges
  * pears

Numbered list:

  1. apples
  2. oranges
  3. pears

A [link](https://bugvm.com).

    This is using 4 spaces.
    Again to be continued...

```
This is using 3-back-ticks.
Again to be continued...
```

Ok, 3-back-ticks not supported. It must be Github extension.

One `tick` is this.

"""

        val html = com.bugvm.markdown.MarkdownProcessor().markdown(textInMarkdown)

        println( html)
    }
}

