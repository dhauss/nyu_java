package PartI;

import java.util.PriorityQueue;

public class Packet {
	private Byte[] payload;
	private int priority;
	
	public Packet(Byte[] payload, int priority) {
		setPriority(priority);
		setPayload(payload);
	}
	
	@Override
	public String toString() {
		return "Packet [priority=" + getPriority() + "]";
	}

	public Byte[] getPayload() {
		return payload;
	}

	public int getPriority() {
		return priority;
	}

	public void setPayload(Byte[] payload) {
		this.payload = payload;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public static void main(String[] args) {
		PriorityQueue<Packet> pq = new PriorityQueue<>(
				10, 
				((Packet p1, Packet p2) -> p2.getPriority() - p1.getPriority())
				);

		for (int i=0;i<10;i++) {
			Byte[] payload = new Byte[256];
			//populate Byte array because it bothered me that the array was full of null pointers
			for (int j = 0; j < 256; j++) {
			    payload[j] = (byte) ((int) (Math.random() * 255) - 128);
			}
			int priority = (int)(Math.random()*5) + 1;
			Packet p = new Packet(payload, priority);
			pq.add(p);
		}
		
		while (!pq.isEmpty()) {
			System.out.println("got " + pq.remove());
		}
	}

}
