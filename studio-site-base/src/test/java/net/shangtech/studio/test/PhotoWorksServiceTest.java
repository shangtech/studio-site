package net.shangtech.studio.test;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.WorksToStyle;
import net.shangtech.studio.service.IPhotoWorksService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({
	"classpath*:spring.xml"
})
public class PhotoWorksServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired private IPhotoWorksService service;
	
	@Test
	public void testFindByStyle(){
		Pagination<WorksToStyle> pagination = new Pagination<>();
		service.findByStyleByPage(pagination, 0L);
	}
	
}
