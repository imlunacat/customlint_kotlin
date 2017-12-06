package customlint
import com.android.tools.lint.checks.infrastructure.LintDetectorTest;
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import org.intellij.lang.annotations.Language
import java.io.IOException
import java.util.*
import java.util.Collections.singletonList
import com.android.tools.lint.checks.infrastructure.TestFiles.java
import com.android.tools.lint.checks.infrastructure.TestFiles.manifest
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class ConcurrentClassDetectorTest {
    @Throws(IOException::class)
    @Test
    fun testRaw() {

//        val backgroundLoader = load(
//                fileName = "BackgroundLoader.java")
//        val issueBackgroundLoader = load(
//                fileName = "IssuedBackgroundLoader.java")
//        val noIssueBackgroundLoader = load(
//                fileName = "NoIssuedBackgroundLoader.java")

        val vh = load(fileName = "multiadapter/MultiViewHolder.java")
        val inner = load(fileName = "multiadapter/InnerClassMultiViewHolder.java")
        lint().files(
                java(vh),
                java(inner)
        )
                .issues(InnerClassDetector.ISSUE)
                .run()
                .expectClean()
    }


    private fun load(fileName: String): String {
        return Utils.readResource(
                resourceName = fileName,
                clazz = ConcurrentClassDetectorTest::class.java)
    }
}