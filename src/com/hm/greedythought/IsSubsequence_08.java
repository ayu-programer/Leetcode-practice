package src.com.hm.greedythought;


/**
 * ̰��˼�룺��������
 * s = "abc", t = "ahbgdc"    Return true.
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 * �������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 * ����ؼ���ͨ��index��ȷ��˳��
 */
public class IsSubsequence_08 {
    public static void main(String[] args) {
        String s = "chg", t = "ahbgdc";
        System.out.println(IsSubsequence_08.isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null){
            return false;
        }
        int index = -1;
        for (char c : s.toCharArray()) {

            index = t.indexOf(c,index+1);
            if (index == -1) {
                return false;
            }
        }
        return true;

//        if(s==null||t==null)
//            return false;
//        int indexs=0;
//        int indext=0;
//        while(indexs<s.length()&&indext<t.length()){
//            if(s.charAt(indexs)==t.charAt(indext)){
//                indexs++;
//            }
//            indext++;
//        }
//        return indexs==s.length();
    }

}
