package customlint

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestLintTask
import org.junit.Test
import java.io.File
import java.io.IOException

class XMLScannerTest {
    @Throws(IOException::class)
    @Test
    fun testScanner() {

        val xml = """
            |<?xml version="1.0" encoding="utf-8"?>
            |<resources>
            |    <string name="app_name_wrong_word">App 名稱</string>
            |</resources>""".trimIndent()
        TestLintTask.lint().files(
//                TestFile.XmlTestFile.create("values-zh-rTW/strings.xml",xml),
//                TestFile.ManifestTestFile()
        )
                .sdkHome(File("/Users/lunacat/Documents/android-sdk"))
                .issues(XmlScannerImpl.ISSUE)
                .run()
                .expect("")
    }
}