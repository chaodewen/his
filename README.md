# mdsp-his

Simulation of a hostipal information system for medical data security system.

### tips
1. *.hbm.xml的id字段要加上<generator class="native"/>才会自动生成,IDEA的Persistence插件生成的XML文件不会对应数据库生成这一属性;
2. IDEA的Persistence插件生成的*.hbm.xml中字段始终为NOT NULL;
3. 遇到部分字段Lazy加载的问题可以在获取对象方法的注解中加入fetch = FetchType.EAGER;
4. 上述问题还有一种解决方法,在*.hbm.xml中外键标签中加入lazy="false"关闭Lazy加载。