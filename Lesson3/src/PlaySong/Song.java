package PlaySong;

public class Song {
	public String songName;		//歌名
	public String singer;		//歌手
	public int duration;		//时长
	
	public Song(String sn, String s, int d) {
		this.songName = sn;
		this.singer = s;
		this.duration = d;
	}
}
