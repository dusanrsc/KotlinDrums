// Imports section.
import java.io.File
import javax.sound.sampled.AudioSystem

// Play drums function.
fun playDrums(beats: String, file: String) {
    val parts = beats.split("x")
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file)
        } else {
            Thread.sleep(100 * (part.length + 1L))
            if (count < beats.length) {
                playSound(file)
            }
        }
    }
}

// Play sound function.
fun playSound(file: String) {
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(
        File(file)
    )
    clip.open(audioInputStream)
    clip.start()
}

// Main program function.
fun main () {
    playDrums("x-x-x-x-x-", "audio/toms.aiff")
    playDrums("x-----x-----", "audio/crash_cymbal.aiff")
    playDrums("xx--xx--x-x-x", "audio/high_hat.aiff")
    playDrums("x-----x-----", "audio/crash_cymbal.aiff")
}