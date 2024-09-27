package main;

import music.MusicOrganizer;

public class Main {
  public static void main(String[] args) {
    MusicOrganizer organizer = new MusicOrganizer();
    organizer.listAllTracks();
    organizer.playTrack(0); 
    organizer.playTrack(1);

    organizer.stopTrack();

    organizer.playTrack(2);
  }
}
