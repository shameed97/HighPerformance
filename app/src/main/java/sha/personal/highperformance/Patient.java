package sha.personal.highperformance;

import android.util.Log;

import androidx.databinding.BindingAdapter;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;


public class Patient implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("user_details")
        @Expose
        private List<UserDetail> userDetails = null;

        public List<UserDetail> getUserDetails() {
            return userDetails;
        }

        public void setUserDetails(List<UserDetail> userDetails) {
            this.userDetails = userDetails;
        }

    }

    public class UserDetail implements Serializable {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("age")
        @Expose
        private String age;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("marital_status")
        @Expose
        private String maritalStatus;
        @SerializedName("created_at")
        @Expose
        private String created;
        @SerializedName("created_by")
        @Expose
        private String createdBy;

        @SerializedName("contact_no")
        @Expose
        private String contact_no;

        @SerializedName("address")
        @Expose
        private String address;

        @SerializedName("area")
        @Expose
        private String area;

        @SerializedName("img_url")
        @Expose
        private String img_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String created() {
            return created;
        }

        public void created(String created) {
            this.created = created;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getContact() {
            return contact_no;
        }

        public void setContact(String contact_no) {
            this.contact_no = contact_no;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        @Override
        public String toString() {
            return "UserDetail{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", email='" + email + '\'' +
                    ", age='" + age + '\'' +
                    ", gender='" + gender + '\'' +
                    ", maritalStatus='" + maritalStatus + '\'' +
                    ", created='" + created + '\'' +
                    ", createdBy='" + createdBy + '\'' +
                    ", contact_no='" + contact_no + '\'' +
                    ", address='" + address + '\'' +
                    ", area='" + area + '\'' +
                    ", img_url='" + img_url + '\'' +
                    '}';
        }
    }

    @BindingAdapter("android:loadImage")
    public static void loadImage(CircularImageView imageView, String imgUrl) {
        Log.e("TAG", "loadImage: "+imgUrl );
        if (imgUrl!=null && !imgUrl.equals(""))
            Picasso.get().load(imgUrl).placeholder(R.drawable.ic_launcher_background).into(imageView);
    }


}


