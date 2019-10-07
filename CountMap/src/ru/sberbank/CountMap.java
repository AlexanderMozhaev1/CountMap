package ru.sberbank;

import java.util.HashMap;
import java.util.Map;

public class CountMap <E>{

    private Map<? super E, Integer> dictionary;
    CountMap(){
        dictionary = new HashMap<>();
    }

    // добавляет элемент в этот контейнер.
    public void add(E elem) {
        if (dictionary.get(elem) == null)
            dictionary.put(elem, 1);
        else
            dictionary.put(elem, dictionary.get(elem) + 1);
    }

    //Возвращает количество добавлений данного элемента
    public int getCount(E elem){
        if(dictionary.get(elem) != null)
        return dictionary.get(elem);
        return 0;
    }

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    public int remove(E elem){
        var val = dictionary.remove(elem);
        return val == null ? 0 : val;
    }

    //количество разных элементов
    public int size(){
        return dictionary.size();
    }


    //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значенияё
    public void addAll(CountMap source){
        for (Map.Entry<E, Integer> item : ((Map<E, Integer>)source.toMap()).entrySet()){
            dictionary.merge(item.getKey(),item.getValue(), (oldVal, newVal) -> newVal + oldVal);
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений

    public Map<? super E, Integer> toMap(){
        return dictionary;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    public void toMap(Map<? super E,Integer> destination){
        for(Map.Entry<? super E,Integer> elem : dictionary.entrySet()){
            destination.merge((E) elem.getKey(), elem.getValue(),(oldVal, newVal) -> newVal + oldVal);
        }
    }


    @Override
    public String toString() {
        return "CountMap{" +
                "dictionary=" + dictionary +
                '}';
    }
}
