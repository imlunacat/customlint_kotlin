package customlint

import com.android.tools.lint.checks.infrastructure.TestFiles
import com.android.tools.lint.checks.infrastructure.TestLintTask
import org.junit.Test
import java.io.File

class BinaryResourceScannerTest {
    @Test
    fun foo() {
        // TODO: not work. How to create a testing Bitmap?
        TestLintTask.lint().files(
                TestFiles.image("123.png", 100, 100)
        )
                .sdkHome(File("/Users/lunacat/Documents/android-sdk"))
                .issues(BinaryResourceScannerImpl.ISSUE)
                .run()
                .expect("No warnings.")
    }
}