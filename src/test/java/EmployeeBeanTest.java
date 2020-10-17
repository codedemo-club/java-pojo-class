import org.apache.commons.beanutils.PropertyUtils;
import org.junit.jupiter.api.Test;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeBeanTest {
    @Test
    void inspectProperties() {
        // 反射EmployeePojo的属性
        List<String> propertyNames =
                Arrays.stream(PropertyUtils.getPropertyDescriptors(EmployeeBean.class))
                        .sequential()
                        .map(PropertyDescriptor::getDisplayName)
                        .collect(Collectors.toList());

        // 打印反射的结果
        System.out.println(propertyNames);

        // 打印的结果总归还需要眼睛来看，而使用断言则不需要眼睛来看控制台，且更规范
        assertEquals(3, propertyNames.size());
        assertEquals("firstName", propertyNames.get(0));
        assertEquals("lastName", propertyNames.get(1));
        assertEquals("startDate", propertyNames.get(2));
    }
}