package jp.or.ktc.se.no19q6;
/**
 * �����̂�\�킷�N���X�B�ʐς̌v�Z��\���͂��̃N���X���󂯎���
 * @author fujisawa
 *
 */
public class Rippotai {
	int hen = 0;
	/**
	 * <p>��ӂ̒����������o�ϐ��Ɋi�[����B�Z�b�^�[���\�b�h����Ēl���Z�b�g���邱�ƂŃJ�v�Z�������������Ă���</p>
	 * <p>
	 * <b>�����T�v</b><br>
	 * <ul>
	 * 	<li>��ӂ̒������i�[���郁���o�[�ϐ��ɒl���Z�b�g����
	 * </ul>
	 * </p>
	 * @param val ��ӂ̒���
	 */
	void setHen(int val){
		this.hen = val;
	}
	/**
	 * <p>�����̂̕\�ʐς����߂�B</p>
	 * <p>
	 * 	<b>�����T�v</b><br>
	 *  <ul>
	 *  	<li>��ӂ̒�������ӂ̒������U���v�Z���A�Ԃ�l�Ƃ��ĕԂ�
	 *  </ul>
	 * </p>
	 * @return �����̂̕\�ʐ�
	 */
	int getHyoMenseki(){
		return  this.hen * this.hen * 6;
	}
	/**
	 * <p>�����̂̕\�ʐς����߂ĕW���o�͂Ɍv�Z���ʂ�\������B</p>
	 * <p>
	 * <b>�����T�v</b>
	 * <ul>
	 *  <li>�\�ʐς����߂�
	 * 	<li>�\�ʐς�\�����镶����𐶐�����
	 * 	<li>���������������W���o�͂ɕ\������
	 * </ul>
	 * </p>
	 */
	void display(){
		StringBuffer sb = new StringBuffer();
		sb.append("��ӂ̒���");
		sb.append( hen );
		sb.append("�Z���`���[�g���̗����̖̂ʐς�");
		sb.append(getHyoMenseki());
		sb.append("�����Z���`���[�g��");
		
		System.out.println(sb.toString());
	}
	
	/**
	 *  �P�̃f�o�b�O�p
	 */
	public static void main(String[] args){
		Rippotai r = new Rippotai();
		// No.1
		r.setHen(9);
		System.out.println(r.hen);
		//No.2
		//r.setHen(1.5);
		// No.3
		r = new Rippotai();
		System.out.println(r.getHyoMenseki());
		// No.4
		r.setHen(-1);
		System.out.println(r.getHyoMenseki());
		// No.5
		r.setHen(0);
		System.out.println(r.getHyoMenseki());
		// No.6
		r.setHen(1);
		System.out.println(r.getHyoMenseki());
		// No.7
		r.setHen(9);
		System.out.println(r.getHyoMenseki());
		// No.8,9,10
		r.setHen(9);
		r.display();
	}
}