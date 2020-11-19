package sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		List<Sample> list = Arrays.asList(
				new Sample(10),
				new Sample(20),
				new Sample(30));

//		【Consumer】---処理するだけ。リターン無し
		Consumer<Sample> c = x -> System.out.println(list.contains(x));
		c.accept(new Sample(2));

//		【Supplier】---引数を受け取らない。リターンだけ返す
//		Supplier<Integer> s = () -> list.get(0).getNum();
//		System.out.println(s.get());;
		Supplier<Sample> s = () -> list.get(0);
		System.out.println(s.get());;

//		【Predicate】---引数を評価し、booleanを返す
		Predicate<Sample> p = x -> list.contains(x);
		System.out.println(p.test(new Sample(10)));

//		【Function】---引数を指定した型でリターン
		Function<String,Integer> f = x -> x.length();
		System.out.println(f.apply(new Sample(30).getBango()));
//		Functionの引数にbooleanは入れられない。なぜなら、booleanはプリミティブだから。
//		よってintの不可
//		Function<>の<>内に入れられるのは、ジェネリクス。＝参照型だけ。
//		クラスとか、Integer,Stringなど..

//		〖Q〗Functionの指定型に関数は可能なのか？
	}
}
class Sample{
	private int num;
	private String bango = "sample_bango";
	public Sample(int num) {
		this.num = num;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Sample == false) {
			return false;
		}
		if(this.num == ((Sample) obj).num) {
			return true;
		}
		return false;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBango() {
		return this.bango;
	}
}

//結果
//[Ljava.lang.Integer;@3712b94
//[Ljava.lang.Integer;@2833cc44
//true
//false
//false
//true
//ok








