### 각 클래스의 기능을 간략히 설명
- Battery: 초기 배터리 level은 100으로, 배터리를 소모하면 LevelDisplay, LowBatteryWarning 클래스에 이를 통지한다.
- BatteryLevelDisplay: 배터리 소모된 양을 출력한다. 
- LowBatteryWarning: LOW배터리 잔량(30)을 기준으로 비교해서 경고해서 출력한다.

### OCP 위반하는 부분을 명시하라 
- Battery와 LowBatteryWarning, BatteryLevelDisplay와의 결합으로 인해서, 만약에 배터리를 소모했을 떄 통지를 하는 추가 적인 작업이 생겼을때, Battery 클래스를 수정하게 되는 일이 발생한다.

### Battery 클래스 설계의 취약점을 옵저버 패턴을 활용해 개선하는 방법을 설명
- 변경 대상이 되는 Battery의 공통적인 부분을 Subject(추상 클래스로) 추출을 하고, Observer(통지대상) 인터페이스를 만들어서, LevelDisplay와 BatteryWarning에서 각각 해당 Observer를 구현하도록 변경한다.