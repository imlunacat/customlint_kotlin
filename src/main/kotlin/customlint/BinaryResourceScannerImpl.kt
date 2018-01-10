package customlint

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.*

class BinaryResourceScannerImpl:  Detector(), Detector.BinaryResourceScanner {
    companion object {
        val ISSUE = Issue.create(
                "BinaryResourceScannerImpl", // id
                "BinaryResourceScannerImpl short", // short description
                "BinaryResourceScannerImpl long", // long  description
                Category.CORRECTNESS,
                6,
                Severity.WARNING,
                Implementation(BinaryResourceScannerImpl::class.java, Scope.BINARY_RESOURCE_FILE_SCOPE))
    }

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return folderType == ResourceFolderType.DRAWABLE
    }

    override fun checkBinaryResource(context: ResourceContext) {
        super.checkBinaryResource(context)
    }
}