public class GenderGenerator {
    public String getSexType () {

        String sexType;

        if (Math.random() < 0.5) {
            sexType = "М";
        } else {
            sexType = "Ж";
        }
        return sexType;
    }
}
