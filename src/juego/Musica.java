package juego; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.AudioInputStream; 
import java.io.File; 
 
public class Musica { 
 private Clip clip; 
 
 public void cargarSonido(String ruta) { 
  try { 
   File archivoSonido= new File(ruta); 
   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido); 
   clip = AudioSystem.getClip(); 
   clip.open(audioInputStream); 
  }catch(Exception e) { 
   e.printStackTrace(); 
  } 
 } 
  
  
 public void reproducir() { 
  if (clip !=null) { 
   clip.setFramePosition(0); 
   clip.start(); 
  } 
 } 
  
 public void detener() { 
  if (clip != null && clip.isRunning()) { 
   clip.stop(); 
  } 
 } 
  
 	
 
}

