
public class Dog {
        private int age;
        private String owner;
        private String breed;
        
        public static boolean hasSameOwner (Dog dog1, Dog dog2) {
        	return dog1.getOwner().equalsIgnoreCase(dog2.getOwner());
        }
        
        public static double aveAge(Dog[] dogArray) {
        	double ave = 0;
        	double totalAge = 0;
        	int dogCount = dogArray.length;
        	
        	for(Dog dog: dogArray) {
        		totalAge += dog.getAge();
        	}
                	
        	ave = totalAge/dogCount;
        	
        	return ave;
        }
        

        @Override
		public String toString() {
			return "Breed: " + breed + ", Owner: " + owner + ", Age: " + age; 
					
		}

		public Dog() {
        	this(0, "unknown", "unknown");
        }
        
        public Dog(int age, String owner, String breed) {
			setAge(age);
			setOwner(owner);
			setBreed(breed);
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}

		public String getBreed() {
			return breed;
		}

		public void setBreed(String breed) {
			this.breed = breed;
		}

		public static void main(String[] args) {
                Dog[] dogs = new Dog[5];
                dogs[0] = new Dog(4, "Stephen Colbert", "Boxer");
                dogs[1] = new Dog(8, "Dexter Morgan", "Corgi");
                dogs[2] = new Dog(12, "John Smith", "Labrador");
                dogs[3] = new Dog(50, "Methusaleh", "Chihuahua");
                dogs[4] = new Dog(6, "stephen colbert", "Mutt");
                
                System.out.println(dogs[1]);
                System.out.println("Average: " + aveAge(dogs));
                System.out.println(hasSameOwner(dogs[2], dogs[4]));
                System.out.println(hasSameOwner(dogs[0], dogs[4]));


                
        }
}