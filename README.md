#Tumor and Non-Tumor Patch Classification using a Contrastive Learning Algorithm
The classifier_tumor_nontumor_patches_code.ipynb code provides an implementation of a tumor vs. non-tumor patch classifier on breast cancer Whole Slide Images (WSIs).

The workflow consists of:
Feature extraction using a contrastive learning algorithm.
Patch classification based on the extracted features.

#Additional Provided Scripts (.groovy format)
groovy_script_for_extract_patches.gvy
Extracts tumor and non-tumor patches from annotated regions in WSIs based on QuPath annotations. This script should be run inside QuPath.

groovy_script_area_perimeter_regions_annotated.gvy
Calculates and saves the area and perimeter of each annotated region from QuPath into a spreadsheet file.
For every extracted patch, the script records: WSI ID, Patch ID, Annotation type (Tumor or Non-Tumor), Area, Perimeter

#Run the Classifier in Google Colab
The classifier code has been executed in Google Colab to demonstrate its correct functionality and workflow.

You can open and run the notebook directly via the link below:
https://colab.research.google.com/drive/1cqkeZFd_vGNzVPla8BvB4mzMjRSEX9mV#scrollTo=6CKeBxYTUSv8



