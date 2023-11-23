public class GuitarHero {

    public static final int SAMPLING_RATE = 44100;
    public static final double CONCERT_A = 440;



    public static void main(String[] args) {
        
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] notes = new GuitarString[37];
        for (int i = 0; i < 37; i++){
            notes[i]= new GuitarString(440 * Math.pow(1.05956, (i+1)-24));
        }
        int ind = 0;
        while (true) {

            // check if the user has typed a key, and, if so, process it
            
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                ind = keyboard.indexOf(key);
                if (ind != -1){
                    notes[ind].pluck();
                  
                    
                    
                }
                
                
                
            }
            if (ind != -1){
                StdAudio.play(notes[ind].sample());
                notes[ind].tic();
            }

            

            // compute the superposition of the samples
            
            
            
            // send the result to standard audio
           

            // advance the simulation of each guitar string by one step
           
        }


    }




}
