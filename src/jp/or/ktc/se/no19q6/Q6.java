package jp.or.ktc.se.no19q6;
/**
 * �@<p>���̃v���O�����̖ړI�́A�����̖̂ʐς����߂ĕ\�����邱�Ƃł���B�R�}���h���C�����痧���̂̈�Ђ̒�������͂��A�e�����̂̕\�ʐς�\������B
 * �@�Ȃ��A�R�}���h���C������͕����̗����̂̏�����͂ł�����̂Ƃ���B</p>
 * 
 *   <p><b>���s���ʗ�</b> <br>
 *   
 *   &gt; java jp.or.ktc.se.no19q6.Q6 10<br>
 *   <b>��ӂ̒���10�Z���`���[�g���̗����̂̕\�ʐς�600�����Z���`���[�g��</b>
 *
 * 	</p>
 *  <p>
 *  &gt; java jp.or.ktc.se.no196.Q6 1 2 3<br>
 *  <b>��ӂ̒���1�Z���`���[�g���̗����̂̕\�ʐς�6�����Z���`���[�g��</b><br>
 *  <b>��ӂ̒���2�Z���`���[�g���̗����̂̕\�ʐς�24�����Z���`���[�g��</b><br>
 *  <b>��ӂ̒���3�Z���`���[�g���̗����̂̕\�ʐς�54�����Z���`���[�g��</b>
 *  </p>
 */
public class Q6 {

	/**
	 * <p>���C�����\�b�h�B�R�}���h���C���̈����̃`�F�b�N�͍s��Ȃ�</p>
	 * <p>
	 * <b>�����T�v</b><br>
	 * 	<ul>
	 * 		<li>�����̐����� Rippotai�N���X�̃I�u�W�F�N�g�𐶐����Ĕz��Ɋi�[����
	 * 		<li>���ꂼ���Rippotai�I�u�W�F�N�g�Ɉ����̒l(��ӂ̒����j���Z�b�g����
	 * 		<li>�S�Ă�Rippotai�I�u�W�F�N�g�̕\�ʐς̌v�Z���ʂ�\������
	 * 	</ul>
	 * </p>
	 * @param args �����̂̈�Ђ̒����������Ƃ��Ď󂯎��
	 */
	public static void main(String[] args) {
		Rippotai rippotaiArray[] = new Rippotai[args.length];
		
		int hen = 0 ;
		for( int i = 0 ; i < rippotaiArray.length ; i++ ){
			rippotaiArray[i] = new Rippotai();
			
			hen = Integer.parseInt(args[i]);
			rippotaiArray[i].setHen(hen);
			rippotaiArray[i].display();
		}
	}

}
