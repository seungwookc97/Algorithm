-- 2번 x and 1 이나 3 10(2)랑 OR 했을때 2가 아니고,     101(3) 이랑 & 했을떄 0이 아니고 
SELECT COUNT(*) COUNT FROM ECOLI_DATA
    WHERE GENOTYPE & 2 != 2 AND GENOTYPE & 5!=0 ;