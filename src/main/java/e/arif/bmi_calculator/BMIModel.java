package e.arif.bmi_calculator;

public class BMIModel {

    double kilogram;
    double meter;
    Boolean error;
    String errorMsg;

    public BMIModel(double w, double h) {
        this.kilogram = w;
        this.meter = h;
    }

    void setError(String errorMsg) {
        this.error = true;
        this.errorMsg = errorMsg;
    }

    void resetError() {
        this.error = false;
        this.errorMsg = " ";
    }

    double getBMI() {
        double bmi = 0;
        if (this.kilogram <= 0 && this.meter > 0) {
            setError("Error: Non-Positive Weight");
        }
        else if (this.meter <= 0 && this.kilogram > 0) {
            setError("Error: Non-Positive Height");
        }
        else if (this.kilogram <= 0 && this.meter <= 0) {
            setError("Error: Non-Positive Weight & Height");
        }
        else {
            resetError();
            bmi = this.kilogram / (this.meter * this.meter);
        }
        return bmi;
    }

    double reduceWeight() {
        double wt = 0.0;
        if (getBMI() <= 25) {
            wt = 0;
        } else if (getBMI() > 25) {
            wt = (getBMI() - 25) * this.meter * this.meter;
        }
        return wt;
    }

    double gainWeight(){
        if (getBMI() < 18.5){
            return (18.5 - getBMI()) * this.meter * this.meter;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        double bmi = this.getBMI();
        String s = "";
        if (error) {
            s = errorMsg;
        }
        else {
            s = "Your BMI is " + String.format("%.2f", bmi);

            if (bmi < 18.5) {
                s += "\n" + "You are Underweight";
                s += "\n" + "You should gain weight by " + String.format("%.2f", gainWeight())
                        + " KG or " + String.format("%.2f", gainWeight() * 2.2) + " Pounds";
            } else if (bmi < 25.0) {
                s += "\n" + "You are Normal";
            } else if (bmi < 30) {
                s += "\n" + "You are Overweight";
                s += "\n" + "You should reduce your weight by " + String.format("%.2f", reduceWeight())
                        + " KG or " + String.format("%.2f", reduceWeight() * 2.2) + " Pounds";
            } else if (bmi >= 30) {
                s += "\n" +"You are Obese";
                s += "\n" + "You should reduce your weight by " + String.format("%.2f", reduceWeight())
                        + " KG or " + String.format("%.2f", reduceWeight() * 2.2) + " Pounds";
            }
        }
        return s;
    }
}