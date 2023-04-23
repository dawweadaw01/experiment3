package com.lhj.util;
import com.lhj.dao.LogDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
@Aspect
public class LogService {
    @Resource
    private LogDao logDao;
    // 在service的增方法执行之后，记录日志
    //
    @AfterReturning("execution(* com.lhj.service.DepartmentService.add(..)))")
    public void beforeDepartmentDaoAdd(JoinPoint joinPoint){
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String message = "在" + declaringTypeName + "类的" + methodName + "方法执行之后，插入了一条数据";
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        int insertLog = logDao.insertLog(message, now);
        if (insertLog > 0){
            System.out.println("日志插入成功");
        }else {
            System.out.println("日志插入失败");
        }
    }
    @AfterReturning("execution(* com.lhj.service.DepartmentService.mod(..)))")
    public void beforeDepartmentDaoMod(JoinPoint joinPoint){
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String message = "在" + declaringTypeName + "类的" + methodName + "方法执行之后，修改了一条数据";
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        int insertLog = logDao.insertLog(message, now);
        if (insertLog > 0){
            System.out.println("日志插入成功");
        }else {
            System.out.println("日志插入失败");
        }
    }
    @AfterReturning("execution(* com.lhj.service.DepartmentService.del(..)))")
    public void beforeDepartmentDaoAdel(JoinPoint joinPoint){
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String message = "在" + declaringTypeName + "类的" + methodName + "方法执行之后，删除了一条数据";
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        int insertLog = logDao.insertLog(message, now);
        if (insertLog > 0){
            System.out.println("日志插入成功");
        }else {
            System.out.println("日志插入失败");
        }
    }
    @AfterReturning("execution(* com.lhj.service.EmployeeService.add(..)))")
    public void beforeEmployeeDaoAdd(JoinPoint joinPoint){
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String message = "在" + declaringTypeName + "类的" + methodName + "方法执行之后，插入了一条数据";
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        int insertLog = logDao.insertLog(message, now);
        if (insertLog > 0){
            System.out.println("日志插入成功");
        }else {
            System.out.println("日志插入失败");
        }
    }
    @AfterReturning("execution(* com.lhj.service.EmployeeService.mod(..)))")
    public void beforeEmployeeDaoMod(JoinPoint joinPoint){
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String message = "在" + declaringTypeName + "类的" + methodName + "方法执行之后，修改了一条数据";
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        int insertLog = logDao.insertLog(message, now);
        if (insertLog > 0){
            System.out.println("日志插入成功");
        }else {
            System.out.println("日志插入失败");
        }
    }
    @AfterReturning("execution(* com.lhj.service.EmployeeService.del(..)))")
    public void beforeEmployeeDaoDel(JoinPoint joinPoint){
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String message = "在" + declaringTypeName + "类的" + methodName + "方法执行之后，删除了一条数据";
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        int insertLog = logDao.insertLog(message, now);
        if (insertLog > 0){
            System.out.println("日志插入成功");
        }else {
            System.out.println("日志插入失败");
        }
    }
}
