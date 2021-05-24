package sha.personal.highperformance;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class ViewProfile {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public Data data;

    public class Data {

        @SerializedName("user_details")
        @Expose
        public UserDetails userDetails;

        @SerializedName("consent_sheet")
        @Expose
        public ConsentSheet consentSheet;
        @SerializedName("demographic_data")
        @Expose
        public DemographicData demographicData;
        @SerializedName("kap_question")
        @Expose
        public KapQuestion kapQuestion;
        @SerializedName("prevalence_habits")
        @Expose
        public PrevalenceHabits prevalenceHabits;
        @SerializedName("clinical_examation")
        @Expose
        public ClinicalExamation clinicalExamation;
        @SerializedName("oral_seeking")
        @Expose
        public OralSeeking oralSeeking;

    }

    public class UserDetails {

        @SerializedName("img_url")
        @Expose
        public String img_url;
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("contact_no")
        @Expose
        public String contact_no;
        @SerializedName("marital_status")
        @Expose
        public String marital_status;

        @Override
        public String toString() {
            return "UserDetails{" +
                    "img_url='" + img_url + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", contact_no='" + contact_no + '\'' +
                    ", marital_status='" + marital_status + '\'' +
                    '}';
        }
    }

    public class ConsentSheet {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("patient_id")
        @Expose
        public String patientId;
        @SerializedName("consent_img")
        @Expose
        public String consentImg;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("created_by")
        @Expose
        public String createdBy;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("updated_by")
        @Expose
        public String updatedBy;

        @Override
        public String toString() {
            return "ConsentSheet{" +
                    "id='" + id + '\'' +
                    ", patientId='" + patientId + '\'' +
                    ", consentImg='" + consentImg + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", createdBy='" + createdBy + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", updatedBy='" + updatedBy + '\'' +
                    '}';
        }
    }

    public class DemographicData {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("patient_id")
        @Expose
        public String patientId;
        @SerializedName("occupation")
        @Expose
        public String occupation;
        @SerializedName("education")
        @Expose
        public String education;
        @SerializedName("income")
        @Expose
        public String income;

        @SerializedName("occup_val")
        @Expose
        public String occup_val;
        @SerializedName("educ_val")
        @Expose
        public String educ_val;
        @SerializedName("income_val")
        @Expose
        public String income_val;

        @SerializedName("total")
        @Expose
        public String total;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("created_by")
        @Expose
        public String createdBy;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("updated_by")
        @Expose
        public String updatedBy;

    }

    public class KapQuestion {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("patient_id")
        @Expose
        public String patientId;
        @SerializedName("oral_cancer")
        @Expose
        public String oralCancer;
        @SerializedName("smoking")
        @Expose
        public String smoking;
        @SerializedName("tobacco")
        @Expose
        public String tobacco;
        @SerializedName("alcohol")
        @Expose
        public String alcohol;
        @SerializedName("growth")
        @Expose
        public String growth;
        @SerializedName("ulcer")
        @Expose
        public String ulcer;
        @SerializedName("red")
        @Expose
        public String red;
        @SerializedName("white")
        @Expose
        public String white;

        @SerializedName("reduce_mouth")
        @Expose
        public String reduce_mouth;

        @SerializedName("oral_kill")
        @Expose
        public String oralKill;
        @SerializedName("prevention")
        @Expose
        public String prevention;
        @SerializedName("treatment")
        @Expose
        public String treatment;
        @SerializedName("medicines")
        @Expose
        public String medicines;
        @SerializedName("surgery")
        @Expose
        public String surgery;
        @SerializedName("more_cancer")
        @Expose
        public String moreCancer;
        @SerializedName("tot_kap")
        @Expose
        public String totKap;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("created_by")
        @Expose
        public String createdBy;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("updated_by")
        @Expose
        public String updatedBy;

        @Override
        public String toString() {
            return "KapQuestion{" +
                    "id='" + id + '\'' +
                    ", patientId='" + patientId + '\'' +
                    ", oralCancer='" + oralCancer + '\'' +
                    ", smoking='" + smoking + '\'' +
                    ", tobacco='" + tobacco + '\'' +
                    ", alcohol='" + alcohol + '\'' +
                    ", growth='" + growth + '\'' +
                    ", ulcer='" + ulcer + '\'' +
                    ", red='" + red + '\'' +
                    ", white='" + white + '\'' +
                    ", reduce_mouth='" + reduce_mouth + '\'' +
                    ", oralKill='" + oralKill + '\'' +
                    ", prevention='" + prevention + '\'' +
                    ", treatment='" + treatment + '\'' +
                    ", medicines='" + medicines + '\'' +
                    ", surgery='" + surgery + '\'' +
                    ", moreCancer='" + moreCancer + '\'' +
                    ", totKap='" + totKap + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", createdBy='" + createdBy + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", updatedBy='" + updatedBy + '\'' +
                    '}';
        }
    }

    public class PrevalenceHabits {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("patient_id")
        @Expose
        public String patientId;
        @SerializedName("smoking")
        @Expose
        public String smoking;
        @SerializedName("smoking_duration")
        @Expose
        public String smokingDuration;
        @SerializedName("smoking_frequent")
        @Expose
        public String smokingFrequent;
        @SerializedName("chewing")
        @Expose
        public String chewing;
        @SerializedName("chewing_duration")
        @Expose
        public String chewingDuration;
        @SerializedName("chewing_frequent")
        @Expose
        public String chewingFrequent;
        @SerializedName("betelnut")
        @Expose
        public String betelnut;
        @SerializedName("betelnut_duration")
        @Expose
        public String betelnutDuration;
        @SerializedName("betelnut_frequent")
        @Expose
        public String betelnutFrequent;
        @SerializedName("pouching")
        @Expose
        public String pouching;
        @SerializedName("pouching_duration")
        @Expose
        public String pouchingDuration;
        @SerializedName("pouching_frequent")
        @Expose
        public String pouchingFrequent;
        @SerializedName("alcohol")
        @Expose
        public String alcohol;
        @SerializedName("alcohol_duration")
        @Expose
        public String alcoholDuration;
        @SerializedName("alcohol_frequent")
        @Expose
        public String alcoholFrequent;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("created_by")
        @Expose
        public String createdBy;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("updated_by")
        @Expose
        public String updatedBy;

    }

    public class ClinicalExamation {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("patient_id")
        @Expose
        public String patientId;
        @SerializedName("lesions_color")
        @Expose
        public String lesionsColor;
        @SerializedName("change_symentry")
        @Expose
        public String changeSymentry;
        @SerializedName("palpable_lymph")
        @Expose
        public String palpableLymph;
        @SerializedName("fixed_lymph")
        @Expose
        public String fixedLymph;
        @SerializedName("buccal")
        @Expose
        public String buccal;
        @SerializedName("buccal_white")
        @Expose
        public String buccalWhite;

        @SerializedName("buccal_ulcerations")
        @Expose
        public String buccal_mucosa_ulcer;
        @SerializedName("buccal_red")
        @Expose
        public String buccalRed;
        @SerializedName("buccal_papale")
        @Expose
        public String buccalPapale;
        @SerializedName("labial")
        @Expose
        public String labial;
        @SerializedName("labial_ulcerations")
        @Expose
        public String labialUlcerations;
        @SerializedName("labial_white")
        @Expose
        public String labialWhite;
        @SerializedName("labial_red")
        @Expose
        public String labialRed;
        @SerializedName("labial_palpable")
        @Expose
        public String labialPalpable;
        @SerializedName("vestibule")
        @Expose
        public String vestibule;
        @SerializedName("vestibule_ulcertions")
        @Expose
        public String vestibuleUlcertions;
        @SerializedName("vestibule_white")
        @Expose
        public String vestibuleWhite;
        @SerializedName("vestibule_red")
        @Expose
        public String vestibuleRed;
        @SerializedName("vestibule_palpable")
        @Expose
        public String vestibulePalpable;
        @SerializedName("tongue")
        @Expose
        public String tongue;
        @SerializedName("tongue_ulcertions")
        @Expose
        public String tongueUlcertions;
        @SerializedName("tongue_white")
        @Expose
        public String tongueWhite;
        @SerializedName("tongue_red")
        @Expose
        public String tongueRed;
        @SerializedName("tongue_palpable")
        @Expose
        public String tonguePalpable;
        @SerializedName("mouth")
        @Expose
        public String mouth;
        @SerializedName("mouth_ulcertions")
        @Expose
        public String mouthUlcertions;
        @SerializedName("mouth_white")
        @Expose
        public String mouthWhite;
        @SerializedName("mouth_red")
        @Expose
        public String mouthRed;
        @SerializedName("mouth_palpable")
        @Expose
        public String mouthPalpable;
        @SerializedName("palate")
        @Expose
        public String palate;
        @SerializedName("palate_ulcertions")
        @Expose
        public String palateUlcertions;
        @SerializedName("palate_white")
        @Expose
        public String palateWhite;
        @SerializedName("palate_red")
        @Expose
        public String palateRed;
        @SerializedName("palate_palpable")
        @Expose
        public String palatePalpable;
        @SerializedName("gingiva")
        @Expose
        public String gingiva;
        @SerializedName("gingiva_ulcertions")
        @Expose
        public String gingivaUlcertions;
        @SerializedName("gingiva_white")
        @Expose
        public String gingivaWhite;
        @SerializedName("gingiva_red")
        @Expose
        public String gingivaRed;
        @SerializedName("gingiva_palpable")
        @Expose
        public String gingivaPalpable;
        @SerializedName("oropharynx")
        @Expose
        public String oropharynx;
        @SerializedName("oropharynx_ulcertions")
        @Expose
        public String oropharynxUlcertions;
        @SerializedName("oropharynx_white")
        @Expose
        public String oropharynxWhite;
        @SerializedName("oropharynx_red")
        @Expose
        public String oropharynxRed;
        @SerializedName("oropharynx_palpable")
        @Expose
        public String oropharynxPalpable;
        @SerializedName("labila_mucosa")
        @Expose
        public String labilaMucosa;
        @SerializedName("vestibule_test")
        @Expose
        public String vestibuleTest;
        @SerializedName("tongue_test")
        @Expose
        public String tongueTest;
        @SerializedName("floor_mouth")
        @Expose
        public String floorMouth;
        @SerializedName("palate_test")
        @Expose
        public String palateTest;
        @SerializedName("gingiva_test")
        @Expose
        public String gingivaTest;
        @SerializedName("oropharynx_test")
        @Expose
        public String oropharynxTest;
        @SerializedName("exfoliative_site")
        @Expose
        public String exfoliativeSite;
        @SerializedName("exfoliative_results")
        @Expose
        public String exfoliativeResults;
        @SerializedName("biopsy_site")
        @Expose
        public String biopsySite;
        @SerializedName("biopsy_result")
        @Expose
        public String biopsyResult;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("created_by")
        @Expose
        public String createdBy;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("updated_by")
        @Expose
        public String updatedBy;

        @SerializedName("img_url_1")
        @Expose
        public String img_url_1;

        @SerializedName("img_url_2")
        @Expose
        public String img_url_2;

        @SerializedName("img_url_3")
        @Expose
        public String img_url_3;

        @SerializedName("img_url_4")
        @Expose
        public String img_url_4;

        @SerializedName("img_url_5")
        @Expose
        public String img_url_5;

    }

    public class OralSeeking {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("patient_id")
        @Expose
        public String patientId;
        @SerializedName("experienced_dental")
        @Expose
        public String experiencedDental;
        @SerializedName("dental_problem")
        @Expose
        public String dentalProblem;
        @SerializedName("paramedics")
        @Expose
        public String paramedics;
        @SerializedName("self_medications")
        @Expose
        public String selfMedications;
        @SerializedName("government_hospital")
        @Expose
        public String governmentHospital;
        @SerializedName("private_hospital")
        @Expose
        public String privateHospital;
        @SerializedName("private_clinic")
        @Expose
        public String privateClinic;
        @SerializedName("painful_tooth")
        @Expose
        public String painfulTooth;
        @SerializedName("mobile_tooth")
        @Expose
        public String mobileTooth;
        @SerializedName("cavity")
        @Expose
        public String cavity;
        @SerializedName("cleaning")
        @Expose
        public String cleaning;
        @SerializedName("bleeding_gums")
        @Expose
        public String bleedingGums;
        @SerializedName("bad_smell")
        @Expose
        public String badSmell;
        @SerializedName("fear")
        @Expose
        public String fear;
        @SerializedName("distance")
        @Expose
        public String distance;
        @SerializedName("time")
        @Expose
        public String time;
        @SerializedName("transport")
        @Expose
        public String transport;
        @SerializedName("cost")
        @Expose
        public String cost;
        @SerializedName("language_problem")
        @Expose
        public String languageProblem;
        @SerializedName("dental_treatment")
        @Expose
        public String dentalTreatment;
        @SerializedName("bad_experience")
        @Expose
        public String badExperience;
        @SerializedName("dentist_attitude")
        @Expose
        public String dentistAttitude;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("created_by")
        @Expose
        public String createdBy;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("updated_by")
        @Expose
        public String updatedBy;

    }


    @BindingAdapter("android:loadImage")
    public static void loadImage(AppCompatImageView imageView, String imgUrl) {
        Picasso.get().load(imgUrl)
                .into(imageView);
    }

}
