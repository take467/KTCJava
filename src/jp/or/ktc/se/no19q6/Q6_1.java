package jp.or.ktc.se.no19q6;
/**
 * �@<p>���̃v���O�����̖ړI�́A�����̖̂ʐς����߂ĕ\�����邱�Ƃł���B�R�}���h���C�����痧���̂̈�Ђ̒�������͂��A�e�����̂̕\�ʐς�\������B</p>
 * 
 *   <p><b>���s���ʗ�</b> <br>
 *   
 *   &gt; java jp.or.ktc.se.no19q6.Q6 10<br>
 *   <b>��ӂ̒���10�Z���`���[�g���̗����̂̕\�ʐς�600�����Z���`���[�g��</b>
 *
 * 	</p>
 *  <p>
 *  &gt; java jp.or.ktc.se.no196.Q6 1 <br>
 *  <b>��ӂ̒���1�Z���`���[�g���̗����̂̕\�ʐς�6�����Z���`���[�g��</b><br>
 *  </p>
 */
public class Q6_1 {

	/**
	 * <p>���C�����\�b�h�B�R�}���h���C���̈����̃`�F�b�N�͍s��Ȃ�</p>
	 * <p>
	 * <b>�����T�v</b><br>
	 * 	<ul>
	 * 		<li>Rippotai �N���X�̃C���X�^���X�𐶐�
	 * 		<li>�C���X�^���X�Ɉ����Ŏw�肵����ӂ̒������Z�b�g
	 * 		<li>�\�ʐς̌v�Z���ʂ�\������
	 * 	</ul>
	 * </p>
	 * @param args �����̂̈�Ђ̒����������Ƃ��Ď󂯎��
	 */
	public static void main(String[] args) {
		
		int hen = 0 ;
		Rippotai r =  new Rippotai();
			
		hen = Integer.parseInt(args[0]);
		r.setHen(hen);
		r.display();
	}

}
