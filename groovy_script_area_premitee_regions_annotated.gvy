import qupath.lib.objects.PathAnnotationObject
import qupath.lib.objects.classes.PathClass
import qupath.lib.gui.scripting.QPEx
import qupath.lib.common.GeneralTools
import java.io.File

def imageData = QPEx.getCurrentImageData()
def server = imageData.getServer()
def annotations = QPEx.getAnnotationObjects()

def name = GeneralTools.getNameWithoutExtension(server.getMetadata().getName())

def outputFile = new File('C:/Users/zahraali/Desktop/region_geometry_summary.tsv') // Path for saving the outcome

if (!outputFile.exists()) {
    outputFile.text = "WSI_Name\tClass\tArea_µm2\tPerimeter_µm\n"
}

def pixelSize = server.getPixelCalibration().getAveragedPixelSize()

for (annotation in annotations) {
    def roi = annotation.getROI()
    def geometry = roi.getGeometry()
    
    def area = geometry.getArea() * pixelSize * pixelSize
    def perimeter = geometry.getLength() * pixelSize
    
    def annotationClass = annotation.getPathClass()?.toString() ?: "Unknown"
    outputFile.append("${name}\t${annotationClass}\t${area}\t${perimeter}\n")
}

print "Area and Perimeter successfully exported to: ${outputFile.getAbsolutePath()}"


