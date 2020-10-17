import org.apache.commons.beanutils.PropertyUtils;
import org.junit.jupiter.api.Test;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePojoTest {
    @Test
    void inspectProperties() {
        // 反射EmployeePojo的属性
        List<String> propertyNames =
                Arrays.stream(PropertyUtils.getPropertyDescriptors(EmployeePojo.class))
                        .sequential()
                        .map(PropertyDescriptor::getDisplayName)
                        .collect(Collectors.toList());

        // 打印反射的结果
        System.out.println(propertyNames);

        // 打印的结果总归还需要眼睛来看，而使用断言则不需要眼睛来看控制台，且更规范
        assertEquals(1, propertyNames.size());
        assertEquals("start", propertyNames.get(0));
    }
}