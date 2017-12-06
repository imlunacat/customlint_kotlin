package customlint

import com.android.annotations.NonNull
import com.android.annotations.Nullable
import com.android.tools.lint.detector.api.*
import java.util.*
import com.intellij.psi.PsiAnonymousClass
import com.intellij.psi.PsiClass
import com.android.tools.lint.detector.api.JavaContext

class InnerClassDetector : Detector(), Detector.UastScanner {
    companion object {
        val ISSUE = Issue.create(
                "PossibleInnerClassOrAnonymousClass", // id
                "Do not use inner-class or anonymous class", // short description
                "MultiAdapter will use reflection to " +
                        "construct MultiViewHolder instance, inner/anonymous class will contain " +
                        "reference or outer-class and cause reflection fail", // long  description
                Category.CORRECTNESS,
                6,
                Severity.WARNING,
                Implementation(InnerClassDetector::class.java, Scope.JAVA_FILE_SCOPE))
    }

    @Nullable
    override fun applicableSuperClasses(): List<String>? {
        return Collections.singletonList("me.lunacat.multiadapter.MultiViewHolder")
    }

    override fun checkClass(@NonNull context: JavaContext, @NonNull declaration: PsiClass) {
        if (declaration is PsiAnonymousClass) {
            // anonymous class
            report(context, declaration)
        }

        if (declaration.containingClass != null) {
            // inner class
            report(context, declaration)
        }
    }

    private fun report(@NonNull context: JavaContext, @NonNull declaration: PsiClass) {
        val className = declaration.qualifiedName
        val errMessage = String.format("Possible inner class or anonymous class")
        var locationNode = JavaContext.findNameElement(declaration)
        if (locationNode == null) {
            locationNode = declaration
        }
        val location = context.getLocation(locationNode)
        context.report(ISSUE,
                locationNode,
                location,
                errMessage)
    }
}