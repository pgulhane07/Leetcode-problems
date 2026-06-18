class Solution {
    public double angleClock(int hour, int minutes) {
        
        // 1min= 30degree
        // proportion of min. degree = hour+ sam prop of 30
        // hour degree = hour *30 + prop of min
        // subtract two, min of ans or 360-ans

        double minAngle = minutes* 6;
        double proportion = (double)minutes/60;
        hour = hour==12 ? 0:hour;
        double hourAngle = hour * 30 + (proportion * 30);

        if(minAngle > hourAngle){
            double min =minAngle -hourAngle;
            return Math.min(min, 360-min);
        }
        else{
            double min = hourAngle- minAngle;
            return Math.min(min, 360-min);
        }

    }
}