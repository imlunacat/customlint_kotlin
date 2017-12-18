package customlint
import java.io.IOException
import com.android.tools.lint.checks.infrastructure.TestFiles.java
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test
import java.io.File

class IssueDetectorTest {
    @Throws(IOException::class)
    @Test
    fun testRaw() {

//        val backgroundLoader = load(
//                fileName = "BackgroundLoader.java")
//        val issueBackgroundLoader = load(
//                fileName = "IssuedBackgroundLoader.java")
//        val noIssueBackgroundLoader = load(
//                fileName = "NoIssuedBackgroundLoader.java")

        val vh = load(fileName = "src/me/lunacat/multiadapter/MultiViewHolder.java")
        val inner = load(fileName = "src/me/lunacat/multiadapter/InnerClassMultiViewHolder.java")
        lint().files(
                java(vh),
                java(inner)
        )
                .sdkHome(File("/Users/lunacat/Documents/android-sdk"))
                .issues(InnerClassDetector.ISSUE)
                .run()
                .expectMatches("Possible inner class or anonymous class")
    }


    private fun load(fileName: String): String {
        return Utils.readResource(
                resourceName = fileName,
                clazz = IssueDetectorTest::class.java)
    }
}