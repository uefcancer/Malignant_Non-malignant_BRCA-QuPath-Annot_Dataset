# **Malignant and Non-malignant Patches Classification using a Contrastive Learning Algorithm**

The "classifier_malignant_nonmalignant_patches_code.ipynb" code provides an implementation of a classifier for distinguishing between malignant and non-malignant tumor patches in breast cancer Whole Slide Images (WSIs).

The workflow consists of:

- Feature extraction using a contrastive learning algorithm.  
- Patch classification based on the extracted features.

---

## **Additional Provided Scripts (.groovy format)**

**groovy_script_for_extract_patches.gvy**  
Extracts malignant and non-malignant patches from annotated regions in WSIs based on QuPath annotations. This script should be run inside QuPath.

**groovy_script_area_perimeter_regions_annotated.gvy**  
Calculates and saves the area and perimeter of each annotated region from QuPath into a spreadsheet file.  
For every extracted patch, the script records:

- WSI ID  
- Patch ID  
- Annotation type (Malignant or Non-malignant)  
- Area  
- Perimeter

**groovy_script_calculation_of_tissue_area_and_perimeter.gvy**
Calculating the tissue area and perimeter of each WSIs

---

**supplementary_file.csv**

Detailed information on the number of annotated regions and extracted patches per WSI, along with corresponding molecular subtypes, is provided in the supplementary file.

---

**area and perimeter related to the malignant and nonmalignant regions.csv**

Information on the Area and Primeter of the malignant and non-malignant regions, which have been annotated in WSIs.

---

**proportion_of_tissue_area_annotations.csv**

The proportion of tissue area annotated as malignant or non-malignant in relation to the total tissue area for each WSI.

---

## **Run the Classifier in Google Colab**

The classifier code has been executed in Google Colab to demonstrate its correct functionality and workflow.

To open and run the notebook directly, use the link below:  
https://colab.research.google.com/drive/1cqkeZFd_vGNzVPla8BvB4mzMjRSEX9mV#scrollTo=6CKeBxYTUSv8

## **Please remember to cite our paper if you use the scripts!**

**Cite this article:**
Shahraki, Z.A., Jokelainen, O., Valkonen, M. et al. Malignant vs. Non-malignant Annotations on TCGA Breast Cancer Whole Slide Images for AI Analysis. Sci Data (2026). https://doi.org/10.1038/s41597-026-07106-5


<img width="1472" height="1874" alt="Figure1" src="https://github.com/user-attachments/assets/c78240bc-d4a0-4bdc-8b78-a369b0240100" />
