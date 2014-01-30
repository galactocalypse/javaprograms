public class Word extends Element{

String synonyms[],antonyms[],examples[],partofspeech,meaning;
public Word(int id,String n,String m){
super(id,n);
meaning=m;
synonyms=antonyms=examples=null;
partofspeech=null;
}
public Word(int id,String n){
super(id,n);
synonyms=antonyms=examples=null;
meaning=partofspeech=null;
}
String[] getString(){return null;}
}