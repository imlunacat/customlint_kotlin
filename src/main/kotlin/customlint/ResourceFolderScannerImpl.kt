package customlint

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.*

class ResourceFolderScannerImpl: Detector(), Detector.ResourceFolderScanner {
    companion object {
        val ISSUE = Issue.create(
                "ResourceFolderScannerImpl", // id
                "ResourceFolderScannerImpl short", // short description
                "ResourceFolderScannerImpl long", // long  description
                Category.CORRECTNESS,
                6,
                Severity.WARNING,
                Implementation(ResourceFolderScannerImpl::class.java, Scope.RESOURCE_FILE_SCOPE))
    }

    override fun checkFolder(context: ResourceContext, folderName: String) {
        super.checkFolder(context, folderName)
    }

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return super.appliesTo(folderType)
    }
}