<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="客户名称" prop="saleinfoCustomerName">
        <el-input
          v-model="queryParams.saleinfoCustomerName"
          placeholder="请输入客户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="saleinfoStatus">
        <el-select v-model="queryParams.saleinfoStatus" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.sale_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="销售时间" prop="saleinfoCreatetime">
        <el-date-picker clearable
          v-model="queryParams.saleinfoCreatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择销售时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['service:saleinfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['service:saleinfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['service:saleinfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['service:saleinfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="saleinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="saleinfoId" />
      <el-table-column label="商品名称" align="center" prop="goodsName" />
      <el-table-column label="客户名称" align="center" prop="saleinfoCustomerName" />
      <el-table-column label="销售数量" align="center" prop="saleinfoQuantiy" />
      <el-table-column label="库存数量" align="center" prop="goodsNum" />
      <el-table-column label="状态" align="center" prop="saleinfoStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sale_status" :value="scope.row.saleinfoStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="售价" align="center" prop="saleinfoPrice" />
      <el-table-column label="总计" align="center" prop="saleinfoTotalPrice" />
      <el-table-column label="销售时间" align="center" prop="saleinfoCreatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.saleinfoCreatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['service:saleinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['service:saleinfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改订单业务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="客户名称" prop="saleinfoCustomerName">
          <el-input v-model="form.saleinfoCustomerName" placeholder="请输入客户名称" />
        </el-form-item>
        <el-form-item label="商品名称" prop="goodId">
          <el-select v-model="form.goodsId" placeholder="请选择商品名称">
            <el-option 
              v-for="item in options" 
              :key="item.goodsId"
              :label="item.goodsName" 
              :value="item.goodsId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="销售数量" prop="saleinfoQuantiy">
          <el-input v-model="form.saleinfoQuantiy" placeholder="请输入销售数量" />
        </el-form-item>
        <el-form-item label="状态" prop="saleinfoStatus">
          <el-select v-model="form.saleinfoStatus" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.sale_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="售价" prop="saleinfoPrice">
          <el-input v-model="form.saleinfoPrice" placeholder="请输入售价" />
        </el-form-item>
        <el-form-item label="销售时间" prop="saleinfoCreatetime">
          <el-date-picker clearable
            v-model="form.saleinfoCreatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择销售时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
import { listSaleinfo, getSaleinfo, delSaleinfo, addSaleinfo, updateSaleinfo, getGoodsName} from "@/api/service/saleinfo";

export default {
  name: "Saleinfo",
  dicts: ['sale_status'],
  //产品名称
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 订单业务表格数据
      saleinfoList: [],
      // 弹出层标题
      title: "",
      options: [],
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        saleinfoCustomerName: null,
        saleinfoStatus: null,
        saleinfoCreatetime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getWithGoodsName();
  },
  methods: {
    /** 查询订单业务列表 */
    getList() {
      this.loading = true;
      listSaleinfo(this.queryParams).then(response => {
        this.saleinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getWithGoodsName(){
      getGoodsName().then(response => {
        this.options = response.data;
      });
    },
    //取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        saleinfoId: null,
        saleinfoCustomerName: null,
        saleinfoQuantiy: null,
        saleinfoStatus: null,
        saleinfoPrice: null,
        saleinfoTotalPrice: null,
        saleinfoCreatetime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.saleinfoId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();

      this.open = true;
      this.title = "添加订单业务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const saleinfoId = row.saleinfoId || this.ids
      getSaleinfo(saleinfoId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单业务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.saleinfoId != null) {
            updateSaleinfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSaleinfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const saleinfoIds = row.saleinfoId || this.ids;
      this.$modal.confirm('是否确认删除订单业务编号为"' + saleinfoIds + '"的数据项？').then(function() {
        return delSaleinfo(saleinfoIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('service/saleinfo/export', {
        ...this.queryParams
      }, `saleinfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
