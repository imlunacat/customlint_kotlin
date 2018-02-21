package customlint

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.*
import org.w3c.dom.Attr
import org.w3c.dom.Document
import org.w3c.dom.Element

class XmlScannerImpl: Detector(), Detector.XmlScanner {
    companion object {
        val ISSUE = Issue.create(
                "XmlScannerImpl", // id
                "XmlScannerImpl", // short description
                "XmlScannerImpl", // long  description
                Category.CORRECTNESS,
                6,
                Severity.WARNING,
                Implementation(XmlScannerImpl::class.java, Scope.MANIFEST_AND_RESOURCE_SCOPE))
    }

    override fun getApplicableElements(): Collection<String>? {
//        return super.getApplicableElements()
//        return listOf("string")
        return null
    }

    override fun getApplicableAttributes(): Collection<String>? {
//        return getApplicableAttributes()
//        return listOf("name")
        return null
    }

    override fun visitElement(context: XmlContext, element: Element) {
        super.visitElement(context, element)
    }

    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        print("visitAttribute")
        super.visitAttribute(context, attribute)
    }

    override fun visitDocument(context: XmlContext, document: Document) {
        print("visitDocument")
        super.visitDocument(context, document)
    }

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return true
    }
}