public class Homework09  {

    public static void main(String[] args) {
    	Music music = new Music("乃龙唐笑",100);
    	music.play();
    	System.out.println(music.getInfo());
    	}

}
class  Music {
	String name;
	int times;
	public Music (String name ,int times) {
		this.name = name;
		this.times = times;
	}
	//播放功能
	public void play() {
		System.out.println("我播放 " + name +"时间" + times +"秒");
	}
	public String getInfo() {
		return "歌曲名字 "+name + "时长" + times + "秒";
	}
}