package customlint
import java.io.IOException
import com.android.tools.lint.checks.infrastructure.TestFiles.java
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test
import java.io.File

class IssueDetectorTest {
    @Throws(IOException::class)
    @Test
    fun testInnerClass() {
        val vh = load(fileName = "multiadapter/MultiViewHolder.java")
        val inner = load(fileName = "multiadapter/InnerClassMultiViewHolder.java")
        val expect = """
                |src/InnerClassMultiViewHolder.java:6: Warning: Possible inner class or anonymous class [PossibleInnerClassOrAnonymousClass]
                |    public class VH extends MultiViewHolder<String> {
                |                 ~~
                |0 errors, 1 warnings
            """.trimMargin()
        lint().files(
                java(vh),
                java(inner)
        )
                .sdkHome(File("/Users/lunacat/Documents/android-sdk"))
                .issues(InnerClassDetector.ISSUE)
                .run()
                .expect(expect)
    }

    @Throws(IOException::class)
    @Test
    fun testAnonymousClass() {
        val vh = load(fileName = "multiadapter/MultiViewHolder.java")
        val anonymous = load(fileName = "multiadapter/AnonymousViewHolder.java")
        val expect = """
                |src/AnonymousViewHolder.java:5: Warning: Possible inner class or anonymous class [PossibleInnerClassOrAnonymousClass]
                |     MultiViewHolder mh = new MultiViewHolder<String>(){
                |                              ~~~~~~~~~~~~~~~~~~~~~~~
                |0 errors, 1 warnings
            """.trimMargin()
        lint().files(
                java(vh),
                java(anonymous)
        )
                .sdkHome(File("/Users/lunacat/Documents/android-sdk"))
                .issues(InnerClassDetector.ISSUE)
                .run()
                .expect(expect)
    }

    private fun load(fileName: String): String {
        return Utils.readResource(
                resourceName = fileName,
                clazz = IssueDetectorTest::class.java)
    }
}