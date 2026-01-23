import qupath.lib.common.GeneralTools

// 
setImageType('BRIGHTFIELD_H_E')
setColorDeconvolutionStains('{"Name" : "H&E default", "Stain 1" : "Hematoxylin", "Values 1" : "0.65111 0.70119 0.29049", "Stain 2" : "Eosin", "Values 2" : "0.2159 0.8012 0.5581", "Background" : " 255 255 255"}')

// 
runPlugin('qupath.imagej.detect.tissue.SimpleTissueDetection2',
'{"threshold":215,"requestedPixelSizeMicrons":20.0,"minAreaMicrons":10000.0,"maxHoleAreaMicrons":1000000.0,"darkBackground":false,"smoothImage":true,"medianCleanup":true,"dilateBoundaries":false,"smoothCoordinates":true,"excludeOnBoundary":false,"singleAnnotation":true}')

def imageData = getCurrentImageData()
def anns = getAnnotationObjects()

if (anns == null || anns.isEmpty()) {
    print "No tissue annotation found (tissue detection failed)."
    return
}

double totalArea = 0.0
double totalPerimeter = 0.0
int n = 0

anns.each { a ->
    def roi = a.getROI()
    if (roi == null) return

    def geom = roi.getGeometry()      // JTS geometry
    if (geom == null) return

    // area & perimeter from geometry
    totalArea += geom.getArea()
    totalPerimeter += geom.getLength()
    n++
}

def slideName = GeneralTools.getNameWithoutExtension(imageData.getServer().getMetadata().getName())

print "========================================"
print "Slide: " + slideName
print "Tissue annotations counted: " + n
print String.format("Total tissue area: %.4f µm^2", totalArea)
print String.format("Total tissue perimeter: %.4f µm", totalPerimeter)
print "========================================"
