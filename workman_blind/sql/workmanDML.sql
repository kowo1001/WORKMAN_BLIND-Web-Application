-- company ���̺� ��� ����
insert into company values('CU ��������������','����Ұ���1','�λ걤���� ������ ����2�� �ݰ���279���� 81-14','010-9280-7637');
insert into company values('GS25�뱸��������','����Ұ���2','�뱸������ �߱� ������ 99 104�� �� 141ȣ �뱸����Ʈ������','010-8920-8402');
insert into company values('�̸�Ʈ õ�ȼ����� �̴Ͻ�����','����Ұ���3','���ϱ� �Ｚ��� 20 õ�ȼ����� �̴Ͻ�����','010-5326-4292');

-- member ���̺� ȸ�� ����
insert into member values('kwon0329','restplease00','����','kwon0329@naver.com','CU ��������������');
insert into member values('wook999','chukchuk123','������','wook999@gmail.com','GS25�뱸��������');
insert into member values('moon77','lovecat522','�幮��','moon77@naver.com','�̸�Ʈ õ�ȼ����� �̴Ͻ�����');

-- parttimelist ���̺� �˹ٸ���Ʈ ����
insert into parttimelist values(208252,'CU ��������������','kwon0329',1,9,'ä����','2�ð���','�ܱ�');
insert into parttimelist values(208253,'GS25�뱸��������','wook999',2,5,'ä�븶��','3�ð���','���');
insert into parttimelist values(208254,'�̸�Ʈ õ�ȼ����� �̴Ͻ�����','moon77',1,4,'ä����','3�ð���','�ð���');

-- parttimeeval ���̺� �˹��򰡰Խñ� ����
insert into parttimeeval values(1,208252,'kwon0329','CU ��������������','Į�𰡴�','1000000','�Ļ�����','����ؿ�','�մ��̸��ƿ�','����1');
insert into parttimeeval values(2,208253,'wook999','GS25�뱸��������','�ٷΰ�༭ �ۼ�','1200000','ȭ��� ����','ģ���ؿ�','�� ���ƿ�','����2');
insert into parttimeeval values(3,208254,'moon77','�̸�Ʈ õ�ȼ����� �̴Ͻ�����','��� ���־����','900000','���� ��','ȭ�� ���ƿ�','�������� ���ƿ�','����3');

commit;