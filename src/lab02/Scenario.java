package lab02;

/**
 * The main method of this class plays out a scenario...
 * Jack has two cans of soda, RootBeer and GingerAle, 
 * Jill also has two cans, Cherry and Grape.
 * Jack opens his RootBeer first, and gives it to Jill.
 * Jill completely drinks the RootBeer. 
 * Jack asks her if she is still thirsty, Jill responds. 
 * Now Jill opens her Cherry soda and drinks it until
 * she is satisfied, then gives it to Jack. 
 * He takes a sip, but doesn't like it. 
 * Jill checks how much is left in her Cherry soda, but decides
 * not to drink any more. Jack asks Jill if he can try her Grape soda.
 * Jill gives it to Jack and he opens it.
 * Jack drinks about half of it, then stops and tells Jill how he now feels.
 * Finally, they check the amount available in all of the cans.
 */
public class Scenario {
	public static void main(String[] args) {
		// Create people
        Person jack = new Person("Jack");
        Person jill = new Person("Jill");

        // Create sodas
        SodaCan rootBeer = new SodaCan("RootBeer");
        SodaCan gingerAle = new SodaCan("GingerAle");
        SodaCan cherry = new SodaCan("Cherry");
        SodaCan grape = new SodaCan("Grape");

        // Jack opens RootBeer and gives it to Jill
        rootBeer.open();
        System.out.println("Jack opens RootBeer and gives it to Jill.");

        // Jill drinks RootBeer completely
        while (rootBeer.getAmount() > 0) {
            jill.gulpFrom(rootBeer);
        }
		System.out.println("Jill finished the RootBeer.");
        System.out.println(jill);

        // Jack asks if Jill is still thirsty
        System.out.println("Jack: Are you still thirsty?");
		System.out.println("Jill: I am " + jill.getThirstStatus());

        // Jill opens Cherry soda and drinks until satisfied
		System.out.println("Jill opens her Cherry soda and drinks until satisfied.");
        cherry.open();
		while (cherry.getAmount() > 0 && !jill.getThirstStatus().equals("satisfied")) {
            jill.gulpFrom(cherry);
        }

        // Jill gives Cherry soda to Jack, he takes a sip but doesn’t like it
        jack.sipFrom(cherry);
        System.out.println("Jack takes a sip of Cherry but doesn’t like it.");
        System.out.println(jack);

        // Jill checks Cherry amount but decides not to drink more
        System.out.println("Jill checks Cherry: " + cherry.getAmount() + " left, but she decides not to drink more.");

        // Jack asks Jill for Grape soda
        System.out.println("Jack: Can I try your Grape soda?");
        grape.open();
        // Jack drinks about half of it
        int halfAmount = grape.getAmount() / 2;
        while (grape.getAmount() > halfAmount) {
            jack.gulpFrom(grape);
        }
        System.out.println("Jack drinks about half of the Grape.");
        System.out.println(jack);

        // Finally, check amounts in all cans
		System.out.println("\nAmount left in cans");
        System.out.println(rootBeer);
        System.out.println(gingerAle);
        System.out.println(cherry);
        System.out.println(grape);
    }
	


}
