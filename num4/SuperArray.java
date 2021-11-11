public class SuperArray{
  //phase 1
    private String[] array;
    private int size;

    public SuperArray(){
        array = new String[10];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean add(String str){
      if (size() == array.length){
        resize();
        array[size] = str;
        size ++;
      } else {
        array[size] = str;
        size ++;
      }
      return true;
    }

    public String toString(){
        String result = "[";
        for (int i = 0; i < size(); i ++){
            result += array[i];
            if (i != size() - 1){
                result += ", ";
            }
        }
        return result += "]";
    }

    public String toStringDebug(){
        String result = "[";
        for (int i = 0; i < array.length; i ++){
            result += array[i];
            if (i != array.length - 1){
                result += ", ";
            }
        }
        return result += "]";
    }

  //phase 2
  public String get(int index){
    if (index >= size() || index < 0){
      System.out.println("error: index out of bounds");
      return null;
    } else {
      return array[index];
    }
  }

  public String set(int index, String element){
    if (index >= size() || index < 0){
      System.out.println("error: index out of bounds");
      return null;
    } else {
      String orig = array[index];
      array[index] = element;
      return orig;
    }
  }

  //phase 3
  public SuperArray(int initialCapacity){
    array = new String[initialCapacity];
    size = 0;
  }

  private void resize(){
    String[] newarr = new String[2 * array.length + 1];
    for (int i = 0; i < array.length; i ++){
      newarr[i] = array[i];
    }
    array = newarr;
  }

  //phase 4
  public String remove(int index){
    String[] newarr = new String[array.length];
    String removed = "";
    if (index >= size() || index < 0){
      System.out.println("error: index out of bounds");
      return null;
    }
    int n = 0;
    for (int i = 0; i < array.length; i ++){
      if (i != index){
        newarr[n] = array[i];
        n ++;
      } else {
        removed = array[i];
        size --;
      }
    }
    array = newarr;
    return removed;
  }

  public int indexOf(String str){
    for (int i = 0; i < size(); i ++){
      if (array[i].equals(str)){
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String str){
    for (int i = size() - 1; i > 0; i --){
      if (array[i].equals(str)){
        return i;
      }
    }
    return -1;
  }

  public boolean remove(String str){
    int index = indexOf(str);
    if (index == -1){
      return false;
    } else {
      remove(index);
      return true;
    }
  }


  public void add(int index, String str){
    if (size() == array.length){
      resize();
    }
    if (index < 0 || index > size()){
      System.out.println("error: index out of bounds");
    } else {
      for (int i = size() - 1; i >= index; i --){
        array[i + 1] = array[i];
      }
      array[index] = str;
      size ++;
    }
  }

}
