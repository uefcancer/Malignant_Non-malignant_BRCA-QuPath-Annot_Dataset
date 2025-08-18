import qupath.lib.images.servers.LabeledImageServer

def imageData = getCurrentImageData()

// Define output path for Malignant and Non-malignant patches
def name = GeneralTools.getNameWithoutExtension(imageData.getServer().getMetadata().getName())
def pathOutputT = buildFilePath('D:/user/zahraali/Malignant/', 'Malignant_' + name)
mkdirs(pathOutputT)
def pathOutputN = buildFilePath('D:/user/zahraali/Non-malignant/', 'Non-malignant_' + name)
mkdirs(pathOutputN)

// Define output resolution
double requestedPixelSize = 0.5

// Convert to downsample
double downsample = requestedPixelSize / imageData.getServer().getPixelCalibration().getAveragedPixelSize()

// Create an ImageServer function where the patches are derived from Malignant annotations
def labelServer = new LabeledImageServer.Builder(imageData)
    .backgroundLabel(255, ColorTools.WHITE) // Specify background label (usually 0 or 255)
    .downsample(downsample)    // Choose server resolution; this should match the resolution at which tiles are exported
    .addLabel('Malignant', 1)      // Choose output labels (the order matters!)
    .multichannelOutput(false)  // If true, each label is a different channel (required for multiclass probability)
    .build()


// Format Malignant patches + size of the patches without overlap
new TileExporter(imageData)
    .downsample(downsample)     // Define export resolution
    .imageExtension('.png')     // Define file extension for original pixels (often .tif, .jpg, '.png' or '.ome.tif')
    .tileSize(256)              // Define size of each tile, in pixels
    .labeledServer(labelServer) // Define the labeled image server to use (i.e. the one we just built)
    .annotatedTilesOnly(true)  // If true, only export tiles if there is a (labeled) annotation present
    .overlap(0)              // Define overlap, in pixel units at the export resolution
    .writeTiles(pathOutputT)     // Write tiles to the specified directory

print 'Extracting the Malignant patches has been done!'


// Create an ImageServer function where the patches are derived from Non-malignant annotations
def labelServerN = new LabeledImageServer.Builder(imageData)
    .backgroundLabel(255, ColorTools.WHITE) // Specify background label (usually 0 or 255)
    .downsample(downsample)    // Choose server resolution; this should match the resolution at which tiles are exported
    .addLabel('Non-malignant', 1)      // Choose output labels (the order matters!)
    .multichannelOutput(false)  // If true, each label is a different channel (required for multiclass probability)
    .build()


// Format Non-malignant patches + size of the patches without overlap
new TileExporter(imageData)
    .downsample(downsample)     // Define export resolution
    .imageExtension('.png')     // Define file extension for original pixels (often .tif, .jpg, '.png' or '.ome.tif')
    .tileSize(256)              // Define size of each tile, in pixels
    .labeledServer(labelServerN) // Define the labeled image server to use (i.e. the one we just built)
    .annotatedTilesOnly(true)  // If true, only export tiles if there is a (labeled) annotation present
    .overlap(0)              // Define overlap, in pixel units at the export resolution
    .writeTiles(pathOutputN)     // Write tiles to the specified directory
    

print 'Extracting the Non-malignant patches has been done!'


print 'Finished!'

