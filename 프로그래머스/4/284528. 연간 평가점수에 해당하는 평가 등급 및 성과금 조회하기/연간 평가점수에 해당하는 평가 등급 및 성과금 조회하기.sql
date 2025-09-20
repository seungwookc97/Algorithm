-- 코드를 작성해주세요

WITH T AS(
    SELECT 
        E.EMP_NO, 
        E.EMP_NAME, 
        CASE
            WHEN AVG(G.SCORE) >= 96 THEN 'S'
            WHEN AVG(G.SCORE) >= 90 THEN 'A'
            WHEN AVG(G.SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END GRADE,
        E.SAL  
    FROM HR_EMPLOYEES E 
    JOIN HR_GRADE G
    ON E.EMP_NO = G.EMP_NO
    GROUP BY E.EMP_NO, E.EMP_NAME, E.SAL
)

SELECT EMP_NO, 
    EMP_NAME, 
    GRADE, 
    CASE
        WHEN GRADE = 'S' THEN SAL * 0.2
        WHEN GRADE = 'A' THEN SAL * 0.15
        WHEN GRADE = 'B' THEN SAL * 0.1
        ELSE 0
    END BONUS
    FROM T
    GROUP BY EMP_NO, EMP_NAME, GRADE
    ORDER BY EMP_NO;
