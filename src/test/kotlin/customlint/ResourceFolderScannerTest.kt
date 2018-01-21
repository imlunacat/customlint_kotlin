package customlint

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestLintTask
import org.intellij.lang.annotations.Language
import org.junit.Test
import java.io.File
import java.io.IOException

class ResourceFolderScannerTest {
    @Throws(IOException::class)
    @Test
    fun testScanner() {


        val xml = """
            |<?xml version="1.0" encoding="utf-8"?>
            |<resources>
            |    <string name="app_name_wrong_word">App 名稱</string>
            |</resources>""".trimIndent()
        TestLintTask.lint().files(
                TestFile.XmlTestFile.create("values-zh-rTW/strings.xml",xml)
        )
                .sdkHome(File("/Users/lunacat/Documents/android-sdk"))
                .issues(ResourceFolderScannerImpl.ISSUE)
                .run()
                .expect("")
    }
}