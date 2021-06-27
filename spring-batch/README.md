# Spring Batch Example
resource/sample.csv 파일을 읽어서 -> 이름을 대문자로 변경한 후 -> Person 테이블에 저장한다.

## 구성요소
- Reader: ClassPathResource 를 통해서 resource 파일을 읽는다.
- Processor: ItemProcessor 인터페이스를 구현한다.
- Writer: JdbcBatchItemWriter 를 통해서 쿼리문을 쓴다. 

## Jobs (Step1, Step2 ...)
- Job은 step들로 만들어지고,
- 각각의 step은 reader, processor, writer와 관계되어있다.


## 주의
- Person setter를 제외했다가, Reader가 읽어 들일때 예외 발생함 !  
> Jobs are built from steps, where each step can involve a reader, a processor, and a writer.
